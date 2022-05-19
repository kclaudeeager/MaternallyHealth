import {Link, useParams} from "react-router-dom";
import {Button, Form} from "react-bootstrap";
import {Fragment, useState} from "react";
import Advices from "./advice/Advices";
import Children from "./Children";
import Consultants from "../../consultant/Consultants";
import AddBaby from "./AddBaby";

export default function SingleWomen(){
    let params = useParams();
    const [showingContent,setShowingContent] = useState("advices")
    const [isEditOn, setEditOn] = useState(false)
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
                                                <AddBaby/>
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
                                <Form className="card-body">
                                    <div className="row">
                                        <div className="col-sm-3">
                                            <h6 className="mb-0">First Name</h6>
                                        </div>
                                        <div className="col-sm-9 text-secondary">
                                            {isEditOn?(<Form.Control type="text" placeholder="Enter Fist name" />):"aline"}
                                        </div>
                                    </div>
                                    <hr />
                                    <div className="row">
                                        <div className="col-sm-3">
                                            <h6 className="mb-0">Last Name</h6>
                                        </div>
                                        <div className="col-sm-9 text-secondary">
                                            {isEditOn?(<Form.Control type="text" placeholder="Enter Last name" />):"Amore"}

                                        </div>
                                    </div>
                                    <hr />
                                        <div className="row">
                                            <div className="col-sm-3">
                                                <h6 className="mb-0">Email</h6>
                                            </div>
                                            <div className="col-sm-9 text-secondary">
                                                {isEditOn?(<Form.Control type="email" placeholder="Enter email" />):"eric@gmail.com"}

                                            </div>
                                        </div>
                                        <hr />
                                            <div className="row">
                                                <div className="col-sm-3">
                                                    <h6 className="mb-0">Phone</h6>
                                                </div>
                                                <div className="col-sm-9 text-secondary">
                                                    {isEditOn?(<Form.Control type="tel" placeholder="Enter phone" />):"07865555555"}

                                                </div>
                                            </div>
                                            <hr />
                                    <div className="row">
                                        <div className="col-sm-3">
                                            <h6 className="mb-0">Age</h6>
                                        </div>
                                        <div className="col-sm-9 text-secondary">
                                            {isEditOn?(<Form.Control type="number" placeholder="Enter Age" />):"12"}

                                        </div>
                                    </div>
                                    <hr />
                                    <div className="row">
                                        <div className="col-sm-3">
                                            <h6 className="mb-0">Weight</h6>
                                        </div>
                                        <div className="col-sm-9 text-secondary">
                                            {isEditOn?(
                                                    <div className={"row"}>
                                                        <div className={"col-8"}>
                                                            <Form.Control type="number" placeholder="Enter Weight" />
                                                        </div>
                                                        <div className={"col"}><Form.Control type="text" placeholder="Enter unit" /></div>
                                                    </div>
                                                ):"3"}

                                        </div>
                                    </div>
                                    <hr />
                                    <div className="row">
                                        <div className="col-sm-3">
                                            <h6 className="mb-0">Id</h6>
                                        </div>
                                        <div className="col-sm-9 text-secondary">
                                            {isEditOn?(<Form.Control type="text" placeholder="Enter Id" />):"1199943232323456"}

                                        </div>
                                    </div>
                                    <hr />
                                    <div className="row">
                                        <div className="col-sm-3">
                                            <h6 className="mb-0">Residence</h6>
                                        </div>
                                        <div className="col-sm-9 text-secondary">
                                            {isEditOn?(<Form.Control type="text" placeholder="Enter Residence" />):"kigali"}

                                        </div>
                                    </div>
                                                <hr />
                                    <div className="row">
                                        <div className="col-sm-3">
                                            <h6 className="mb-0">Status</h6>
                                        </div>
                                        <div className="col-sm-9 text-secondary">
                                            {isEditOn?(<Form.Control type="text" placeholder="Enter status" />):"good"}

                                        </div>
                                    </div>
                                                    <hr/>
                                    {isEditOn?(<div className="row">
                                        <div className="col-sm-6">
                                            <Button onClick={() => {setEditOn(false)}} className="btn btn-info "
                                                     >Cancel</Button>
                                        </div>
                                        <div className="col-sm-6">
                                            <Button onClick={() => {setEditOn(false)}} className="btn btn-info "
                                                     >Save</Button>
                                        </div>
                                    </div>):(<div className="row">
                                        <div className="col-sm-12">
                                            <Button onClick={() => {setEditOn(true)}} className="btn btn-info "
                                                     >Edit</Button>
                                        </div>
                                    </div>)}

                                </Form>
                            </div>



                        </div>
                    </div>
                </div>
                <div>
                    <div className={"row"}>
                        <div className={"col"}>
                            <button className={"btn btn-light"} onClick={() => {setShowingContent("advices")}}>show advices</button>
                        </div>
                        <div className={"col"}>
                            <button className={"btn btn-light"} onClick={() => {setShowingContent("children")}}>show children</button>
                        </div>
                        <div className={"col"}>
                            <button className={"btn btn-light"} onClick={() => {setShowingContent("consultant")}}>show consultant</button>
                        </div>

                    </div>
                    <hr/>
                    <div className={"row"}>
                        <div className={"col"}>
                            {showingContent==="advices"?<Fragment>
                                <Advices/>
                            </Fragment>:<div></div>}
                            {showingContent==="children"?<div>
                                <Children/>
                            </div>:<div></div>}
                            {showingContent==="consultant"?<Fragment><Consultants/></Fragment>:<div></div>}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}