import SingleWomen from "../../components/dasboard/hospital/dashboard/women/singleWomen/SingleWomen";

export default {
    exact: true,
    name:'Tips',
    protected:false,
    guestOnly: false,
    path:'/mothers/:motherId',
    component:SingleWomen
}