import Users from "../../components/dasboard/users/Users";

export default {
    exact: true,
    name:'Dashboard',
    protected:false,
    guestOnly: false,
    path:'/dashboard/users',
    component:Users
}