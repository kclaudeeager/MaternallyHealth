import {Fragment} from "react";
import AddAdvice from "./AddAdvice";

export default function Advices(){
    return(
        <Fragment>
            <AddAdvice/>
            <div className="card">
                <div className="card-body">
                    <h6 className="card-subtitle mb-2 text-muted">Dr eric</h6>
                    <p className="card-text">some advice given by doctor.</p>
                    <a href="src/components/dasboard/hospital/dashboard/women/singleWomen/advice/Advices#" className="card-link">edit</a>
                    <a href="src/components/dasboard/hospital/dashboard/women/singleWomen/advice/Advices#" className="card-link">delete</a>
                </div>
            </div>
        </Fragment>
    )
}