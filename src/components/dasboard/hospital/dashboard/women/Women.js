import WomenList from "./WomenList";
import AddNewMother from "./AddNewMother";

export default function Women(){

    return(
        <div className={"pt-5"}>
            <div className={"container-fluid"}>
                <div className={"row"}>
                    <div className={"offset-2 col-3"}>
                        <AddNewMother/>
                    </div>
                </div>
                <div className={"row mt-5"}>
                    <div className={"col"}>
                        <WomenList/>
                    </div>
                </div>
            </div>

        </div>
    )
}