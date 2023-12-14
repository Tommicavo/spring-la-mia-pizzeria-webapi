import { createRouter, createWebHistory } from "vue-router";

import HomePage from '@/components/pages/HomePage.vue';
import NotFoundPage from '@/components/pages/NotFoundPage.vue';

import FormPage from '@/components/pages/FormPage.vue';
import DetailPage from '@/components/pages/DetailPage.vue';

const router = createRouter({
    history: createWebHistory(),
    linkExactActiveClass: 'active',
    routes: [
        {path: '/', name: 'HomePage', component: HomePage},
        {path: '/pizzaForm', name: 'FormPage', component: FormPage},
        {path: '/pizzas/{id}', name: 'DetailPage', component: DetailPage},

        {path: '/notFoundPage', name: 'NotFoundPage', component: NotFoundPage},
        {path: '/:pathMatch(.*)*', redirect: '/NotFoundPage'},
    ] 
});

export { router }
