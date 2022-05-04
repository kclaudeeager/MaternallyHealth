import Login from "../../components/login/Login";

export default {
    exact: true,
    name:'Login',
    protected:false,
    guestOnly: false,
    path:'/login',
    component:Login
}