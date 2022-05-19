import {Fragment} from "react";

export default function Advices(){
    return(
        <Fragment>
            <div className="card">
                <div className="card-body">
                    <h6 className="card-subtitle mb-2 text-muted">Dr eric</h6>
                    <p className="card-text">some advice given by doctor.</p>
                    <a href="#" className="card-link">edit</a>
                    <a href="#" className="card-link">delete</a>
                </div>
            </div>
        </Fragment>
    )
}