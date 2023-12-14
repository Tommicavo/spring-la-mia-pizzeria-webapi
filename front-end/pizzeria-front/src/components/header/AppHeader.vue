<script>
  export default {
    name: "AppHeader",
    data() {
      return {
        searchedWord: "",
      };
    },
    components: {},
    props: {},
    computed: {},
    methods: {},
    emits: ["searchBtnPressed"],
  };
</script>

<template>
  <header>
    <h1 class="text-center py-3 text-danger">Pizzeria</h1>
    <div
      class="myNavbar d-flex justify-content-evenly align-items-center w-100 my-5"
    >
      <div class="searchBar">
        <div class="input-group">
          <form
            @submit.prevent="$emit('searchBtnPressed', searchedWord)"
            class="d-flex gap-2"
          >
            <input
              type="text"
              class="form-control"
              placeholder="Search a Pizza..."
              v-model.trim="searchedWord"
            />
            <button class="btn btn-danger" type="submit">Find</button>
          </form>
        </div>
      </div>
      <router-link class="btn btn-success" :to="{ name: 'FormPage' }"
        >Add New Pizza</router-link
      >
    </div>
  </header>
</template>

<style lang="scss" scoped></style>
