import SignUp from "../../components/signup/SignUp";

export default {
    exact: true,
    name:'Login',
    protected:false,
    guestOnly: false,
    path:'/signup',
    component:SignUp
}