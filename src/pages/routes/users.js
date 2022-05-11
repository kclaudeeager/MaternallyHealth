import Users from "../../components/dasboard/users/Users";

export default {
    exact: true,
    name:'Users',
    protected:false,
    guestOnly: false,
    path:'/dashboard/users',
    component:Users
}