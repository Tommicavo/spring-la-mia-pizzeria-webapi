<script>
  import axios from "axios";

  export default {
    name: "FormPage",
    data() {
      return {
        pizza: {
          name: "",
          description: "",
          imageUrl: "",
          price: 0,
        },
      };
    },
    components: {},
    props: {},
    computed: {},
    methods: {
      async storePizza() {
        const endpoint = "http://127.0.0.1:8080/pizzas/api/v1.0";
        try {
          const res = await axios.post(endpoint, this.pizza);
          console.log(res.data);
          this.$router.push({ name: "HomePage" });
        } catch (err) {
          console.error(err);
        }
      },
    },
  };
</script>

<template>
  <h1 class="text-center text-danger py-5">Create your Pizza</h1>
  <div class="d-flex justify-content-center align-items-center">
    <form @submit.prevent="storePizza" class="storeForm">
      <div class="name mb-3">
        <label for="name" class="form-label">Name</label>
        <input
          type="text"
          class="form-control"
          id="name"
          placeholder="Pizza title..."
          v-model.trim="pizza.name"
        />
      </div>
      <div class="description mb-3">
        <label for="description" class="form-label">Description</label>
        <textarea
          class="form-control"
          id="description"
          rows="3"
          v-model.trim="pizza.description"
        ></textarea>
      </div>
      <div class="image mb-3">
        <label for="image" class="form-label">Image url</label>
        <input
          type="text"
          class="form-control"
          id="image"
          placeholder="Image url..."
          v-model.trim="pizza.imageUrl"
        />
      </div>
      <div class="price mb-3">
        <label for="price" class="form-label">Price</label>
        <input
          type="tel"
          class="form-control"
          id="price"
          placeholder="€"
          v-model.trim="pizza.price"
        />
      </div>
      <div class="d-flex justify-content-evenly align-items-center my-5">
        <router-link class="btn btn-primary" :to="{ name: 'HomePage' }"
          >Back</router-link
        >
        <button type="submit" class="btn btn-success">Create</button>
      </div>
    </form>
  </div>
</template>

<style lang="scss" scoped>
  .storeForm {
    flex-basis: 50%;
  }
</style>
