import {createApp} from 'vue'
import 'material-icons/iconfont/material-icons.css';
import "quasar/dist/quasar.prod.css";
import App from './App.vue'
import {Dialog, Quasar} from "quasar";

createApp(App)
    .use(Quasar, {
        plugins: {
            Dialog
        }
    }).mount('#app')
