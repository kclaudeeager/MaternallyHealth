import SingleStaff from "../../components/dasboard/hospital/dashboard/staff/singleStaff/SingleStaff";

export default {
    exact: true,
    name:'staff',
    protected:false,
    guestOnly: false,
    path:'/hospital/:hospitalId/staff/:staffId',
    component:SingleStaff
}