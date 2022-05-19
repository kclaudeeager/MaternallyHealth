import {Link, useParams} from "react-router-dom";
import {Button} from "react-bootstrap";
import {Fragment, useState} from "react";
import Advices from "./Advices";
import Children from "./Children";
import Consultants from "./Consultants";

export default function SingleWomen(){
    let params = useParams();
    const [show,setShow] = useState("advices")
    return(
        <div>

            <div className="container">
                <div className="main-body">
                    <div className="row gutters-sm">
                        <div className="col-md-4 mb-3">
                            <div className="card">
                                <div className="card-body">
                                    <div className="d-flex flex-column align-items-center text-center">
                                        <img src="https://st2.depositphotos.com/1041170/7201/v/950/depositphotos_72018141-stock-illustration-pregnant-woman-symbol-stylized-vector.jpg" alt="Admin"
                                             className="rounded-circle" width="150" />
                                            <div className="mt-3">
                                                <h4>aline View</h4>
                                                <p className="text-secondary mb-1"> live in kigali</p>
                                                <p className="text-muted font-size-sm">nyamirambo</p>
                                                <button className="btn btn-primary">Add child</button>
                                                <button className="btn btn-outline-primary">Delete</button>
                                            </div>
                                    </div>
                                </div>
                            </div>
                            <div className="card mt-3">
                                <ul className="list-group list-group-flush">
                                    <li className="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                        <h6 className="mb-0">
                                            children
                                        </h6>
                                        <span className="text-secondary">0</span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div className="col-md-8">
                            <div className="card mb-3">
                                <div className="card-body">
                                    <div className="row">
                                        <div className="col-sm-3">
                                            <h6 className="mb-0">Full Name</h6>
                                        </div>
                                        <div className="col-sm-9 text-secondary">
                                            aline
                                        </div>
                                    </div>
                                    <hr />
                                        <div className="row">
                                            <div className="col-sm-3">
                                                <h6 className="mb-0">Email</h6>
                                            </div>
                                            <div className="col-sm-9 text-secondary">
                                                eric@gmail.com
                                            </div>
                                        </div>
                                        <hr />
                                            <div className="row">
                                                <div className="col-sm-3">
                                                    <h6 className="mb-0">Phone</h6>
                                                </div>
                                                <div className="col-sm-9 text-secondary">
                                                    07865555555
                                                </div>
                                            </div>
                                            <hr />

                                                <hr />
                                                    <div className="row">
                                                        <div className="col-sm-3">
                                                            <h6 className="mb-0">Address</h6>
                                                        </div>
                                                        <div className="col-sm-9 text-secondary">
                                                            kigali, nyamirambo
                                                        </div>
                                                    </div>
                                                    <hr/>
                                                        <div className="row">
                                                            <div className="col-sm-12">
                                                                <Button className="btn btn-info "
                                                                   href="">Edit</Button>
                                                            </div>
                                                        </div>
                                </div>
                            </div>



                        </div>
                    </div>
                </div>
                <div>
                    <div className={"row"}>
                        <div className={"col"}>
                            <button className={"btn btn-light"} onClick={() => {setShow("advices")}}>show advices</button>
                        </div>
                        <div className={"col"}>
                            <button className={"btn btn-light"} onClick={() => {setShow("children")}}>show children</button>
                        </div>
                        <div className={"col"}>
                            <button className={"btn btn-light"} onClick={() => {setShow("consultant")}}>show consultant</button>
                        </div>

                    </div>
                    <hr/>
                    <div className={"row"}>
                        <div className={"col"}>
                            {show==="advices"?<Fragment>
                                <Advices/>
                            </Fragment>:<div></div>}
                            {show==="children"?<div>
                                <Children/>
                            </div>:<div></div>}
                            {show==="consultant"?<Fragment><Consultants/></Fragment>:<div></div>}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}