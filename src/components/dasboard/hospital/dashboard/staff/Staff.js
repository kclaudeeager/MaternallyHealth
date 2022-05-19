import AddNewStaff from "./AddNewStaff";
import StaffList from "./StaffList";

export default function Staff(){
    return(
        <div className={"pt-5"}>
            <div className={"container-fluid"}>
                <div className={"row"}>
                    <div className={"offset-2 col-3"}>
                        <AddNewStaff/>
                    </div>
                </div>
                <div className={"row mt-5"}>
                    <div className={"col"}>
                        <StaffList/>
                    </div>
                </div>
            </div>

        </div>
    )
}