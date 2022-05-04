import Layout from "../../components/dasboard/Dashboard";

export default {
    exact: true,
    name:'Dashboard',
    protected:false,
    guestOnly: false,
    path:'/dashboard',
    component:Layout
}