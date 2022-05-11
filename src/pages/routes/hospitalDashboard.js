import Dashboard from "../../components/dasboard/hospital/dashboard/Dashboard";


export default {
    exact: true,
    name:'Dashboard',
    protected:false,
    guestOnly: false,
    path:'/hospitalDashboard',
    component:Dashboard
}