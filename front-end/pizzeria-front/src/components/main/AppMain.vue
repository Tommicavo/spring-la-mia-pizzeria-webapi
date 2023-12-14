<script>
  export default {
    name: "AppMain",
    data() {
      return {};
    },
    components: {},
    props: {
      pizzas: Array,
    },
    computed: {},
    methods: {},
  };
</script>

<template>
  <table class="table myTable">
    <thead>
      <tr>
        <th class="ps-3" scope="col">Name</th>
        <th scope="col">Price</th>
        <th class="text-center" scope="col">Tasks</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="pizza in pizzas" :key="pizza.id">
        <td class="ps-3">{{ pizza.name }}</td>
        <td>{{ pizza.price }}</td>
        <td>
          <div class="d-flex justify-content-center align-items-center gap-3">
            <router-link class="btn btn-primary" :to="{ name: 'DetailPage' }"
              >Show</router-link
            >
            <button type="button" class="btn btn-danger">Delete</button>
          </div>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<style lang="scss" scoped></style>
