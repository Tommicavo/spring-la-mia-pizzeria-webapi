<script>
  import axios from "axios";

  export default {
    name: "DetailPage",
    data() {
      return {
        pizza: {},
      };
    },
    components: {},
    props: {},
    computed: {
      pizzaFormattedPrice() {
        return this.pizza.price / 100;
      },
    },
    methods: {
      async fetchPost() {
        const endpoint = `http://127.0.0.1:8080/pizzas/api/v1.0/${this.$route.params.id}`;
        try {
          const res = await axios.get(endpoint);
          this.pizza = res.data;
        } catch (err) {
          console.error(err);
        }
      },
      async deletePizza(pizza_id) {
        const endpoint = `http://127.0.0.1:8080/pizzas/api/v1.0/${pizza_id}`;
        try {
          const res = await axios.delete(endpoint);
          console.log(res.data);
          this.$router.push({ name: "HomePage" });
        } catch (err) {
          console.error(err);
        }
      },
    },
    mounted() {
      this.fetchPost();
    },
    emits: ["delete"],
  };
</script>

<template>
  <div class="pizzaCard d-flex justify-content-center align-items-center h-100">
    <div class="card">
      <img :src="pizza.imageUrl" class="card-img-top" :alt="pizza.name" />
      <div class="card-body">
        <h5 class="card-title text-center py-2">{{ pizza.name }}</h5>
        <div class="description">
          <span class="fw-bold">Description: </span>
          <span>{{ pizza.description }}</span>
        </div>
        <div class="price">
          <span class="fw-bold">Price: </span>
          <span>{{ pizzaFormattedPrice }}€</span>
        </div>
        <footer>
          <router-link class="btn btn-primary" :to="{ name: 'HomePage' }"
            >Back</router-link
          >
          <button
            type="button"
            class="btn btn-danger"
            @click="deletePizza(pizza.id)"
          >
            Delete
          </button>
        </footer>
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped></style>
