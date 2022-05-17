import {useState} from "react";
import {Button, Modal} from "react-bootstrap";

export default function AddNewMother(){

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);


    return(
        <div>
            <Modal show={show} onHide={handleClose} className={"w-100"}>
                <Modal.Header closeButton>
                    <Modal.Title>Modal heading</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    body
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={handleClose}>
                        Save Changes
                    </Button>
                </Modal.Footer>
            </Modal>

            <div className="container">
                <div className="row">
                    <div className="col">
                        <div className="card border rounded" onClick={() => {
                            handleShow();
                        }}>
                            <div className="card-body align-items-lg-center cardRegisterMother">
                                <div className="row">
                                    <div className="col">
                                        <h4 className="text-center text-sm-center text-md-center text-lg-center text-xl-center text-xxl-center registerMotherText">click
                                            to register Mother</h4>
                                    </div>
                                </div>
                                <div className="row">
                                    <div className="col d-inline-flex justify-content-lg-center">
                                        <button className="btn btn-primary btnAddNewMother" type="button">Add
                                            New Mother
                                        </button>
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