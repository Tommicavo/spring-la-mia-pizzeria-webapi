<script>
  import axios from "axios";

  import AppHeader from "@/components/header/AppHeader.vue";
  import AppMain from "@/components/main/AppMain.vue";

  export default {
    name: "HomePage",
    data() {
      return {
        pizzas: [],
        filteredPizzas: [],
      };
    },
    components: {
      AppHeader,
      AppMain,
    },
    props: {},
    computed: {},
    methods: {
      async fetchPizzas() {
        const endpoint = "http://127.0.0.1:8080/pizzas/api/v1.0";
        try {
          const res = await axios.get(endpoint);
          // console.log(res.data);
          this.pizzas = res.data;
          this.filteredPizzas = res.data;
        } catch (err) {
          console.error(err);
        }
      },
      fetchPizzasByName(searchedWord) {
        // console.log(searchedWord);
        if (searchedWord.length == 0) {
          this.filteredPizzas = [...this.pizzas];
          return;
        }
        const filteredPizzas = this.pizzas.filter((pizza) =>
          pizza.name.includes(searchedWord)
        );
        // console.log(filteredPizzas);
        this.filteredPizzas = filteredPizzas;
      },
      async deletePizza(pizza_id) {
        const endpoint = `http://127.0.0.1:8080/pizzas/api/v1.0/${pizza_id}`;
        try {
          const res = await axios.delete(endpoint);
          console.log(res.data);
          this.$router.go();
        } catch (err) {
          console.error(err);
        }
      },
    },
    mounted() {
      this.fetchPizzas();
    },
  };
</script>

<template>
  <AppHeader @searchBtnPressed="fetchPizzasByName" />
  <AppMain :pizzas="filteredPizzas" @delete="deletePizza" />
</template>

<style lang="scss" scoped>
  .myTable {
    border-radius: 2rem;
    overflow: hidden;
  }
</style>
