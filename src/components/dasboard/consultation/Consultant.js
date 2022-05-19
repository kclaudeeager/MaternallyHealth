import {Button, Form} from "react-bootstrap";
import classes from "./Css.module.css";
export default function Consultant(){
    return(
        <div>
            <div id={"add new consultant"} className={""} >
                <div className={"container"}>
                    <Form>
                        <div className={"row"}>
                            <div className={"col"}>
                                <div className="form-group">
                                    <label htmlFor="exampleFormControlInput1">consultation Type</label>
                                    <input type="text" className="form-control" id="exampleFormControlInput1"
                                           placeholder="consultation type..."/>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="exampleFormControlSelect1">patient</label>
                                    <Form.Select id={"exampleFormControlSelect1"} aria-label="Default select example">
                                        <option>select patient</option>
                                        <option value="1">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                    </Form.Select>
                                </div>


                            </div>
                            <div className={"col"}>
                                {/*this is let part*/}
                                <div className="form-group">
                                    <label htmlFor="exampleFormControlTextarea1">Description</label>
                                    <textarea className={"form-control "+classes.textfieldStyling} id="exampleFormControlTextarea1"></textarea>
                                </div>
                            </div>
                        </div>
                        <div className={"row"}>
                            <div className={"offset-7 col"}>
                                <Button> Save</Button>
                            </div>
                        </div>

                    </Form>
                    <div className={"row"}>
                        <div className={"col"}>
                            <div className="row justify-content-center">
                                <div className="col-xl-10 col-xxl-9">
                                    <div className="card shadow">
                                        <div
                                            className="card-header d-flex flex-wrap justify-content-center align-items-center justify-content-sm-between gap-3">
                                            <h5 className="display-6 text-nowrap text-capitalize mb-0">All Consultations</h5>
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
                                                        <th>Created At</th>
                                                        <th>Description</th>
                                                        <th>Patient</th>
                                                        <th className="text-center">Actions</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td className="text-truncate tdTag1">Jmeno Prijmení</td>
                                                        <td className="text-truncate tdTag1">email.prijmeni@sssssssssssssssgmail.com</td>
                                                        <td>Superior</td>
                                                        <td className="text-center">
                                                            <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em"
                                                                 fill="currentColor" viewBox="0 0 16 16"
                                                                 className="bi bi-eye-fill fs-5 text-primary">
                                                                <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"></path>
                                                                <path
                                                                    d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"></path>
                                                            </svg>
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
                        </div>
                    </div>

                </div>
            </div>
        </div>
    )
}