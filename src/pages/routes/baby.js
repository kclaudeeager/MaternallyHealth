import Baby from "../../components/dasboard/hospital/dashboard/baby";

export default {
    exact: true,
    name:'baby',
    protected:false,
    guestOnly: false,
    path:'/mothers/:motherId/baby/:babyId',
    component:Baby
}