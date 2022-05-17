import {Link, useParams} from "react-router-dom";
import {Button} from "react-bootstrap";
import {useState} from "react";

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
                    </div>
                    <hr/>
                    <div className={"row"}>
                        <div className={"col"}>
                            {show==="advices"?<div>

                                <div className="card">
                                    <div className="card-body">
                                        <h6 className="card-subtitle mb-2 text-muted">Dr eric</h6>
                                        <p className="card-text">some advice given by doctor.</p>
                                        <a href="#" className="card-link">edit</a>
                                        <a href="#" className="card-link">delete</a>
                                    </div>
                                </div>
                            </div>:<div></div>}
                            {show==="children"?<div>
                                <div className="row justify-content-center">
                                    <div className="col-xl-10 col-xxl-9">
                                        <div className="card shadow">
                                            <div
                                                className="card-header d-flex flex-wrap justify-content-center align-items-center justify-content-sm-between gap-3">
                                                <h5 className="display-6 text-nowrap text-capitalize mb-0">All children</h5>
                                                <div className="input-group input-group-sm w-auto"><input
                                                    className="form-control form-control-sm" type="text"/>
                                                    <button className="btn btn-outline-primary btn-sm" type="button">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor"
                                                             viewBox="0 0 16 16" className="bi bi-search mb-1">
                                                            <path
                                                                d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"></path>
                                                        </svg>
                                                    </button></div>
                                            </div>
                                            <div className="card-body">
                                                <div className="table-responsive">
                                                    <table className="table table-striped table-hover">
                                                        <thead>
                                                        <tr>
                                                            <th>Name</th>
                                                            <th>birth date</th>
                                                            <th>status</th>
                                                            <th className="text-center">Actions</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr>
                                                            <td className="text-truncate tdTag1">eric</td>
                                                            <td className="text-truncate tdTag1">12.12.2222</td>
                                                            <td>level 2</td>
                                                            <td className="text-center">
                                                                <Link to={"/mothers/mamaEric"}>
                                                                    <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em"
                                                                         fill="currentColor" viewBox="0 0 16 16"
                                                                         className="bi bi-eye-fill fs-5 text-primary">
                                                                        <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"></path>
                                                                        <path
                                                                            d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"></path>
                                                                    </svg>
                                                                </Link>

                                                            </td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div className="card-footer">
                                                <nav>
                                                    <ul className="pagination pagination-sm mb-0 justify-content-center">
                                                        <li className="page-item"><a className="page-link" href="#" aria-label="Previous"><span
                                                            aria-hidden="true">«</span></a></li>
                                                        <li className="page-item"><a className="page-link" href="#">1</a></li>
                                                        <li className="page-item"><a className="page-link" href="#">2</a></li>
                                                        <li className="page-item"><a className="page-link" href="#">3</a></li>
                                                        <li className="page-item"><a className="page-link" href="#" aria-label="Next"><span
                                                            aria-hidden="true">»</span></a></li>
                                                    </ul>
                                                </nav>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>:<div></div>}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}