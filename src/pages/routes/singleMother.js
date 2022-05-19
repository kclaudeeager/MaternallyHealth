import Mother from "../../components/dasboard/hospital/dashboard/women/singleWomen";

export default {
    exact: true,
    name:'mother',
    protected:false,
    guestOnly: false,
    path:'/mothers/:motherId',
    component:Mother
}