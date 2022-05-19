import {Fragment, useState} from "react";
import {Button, Form, Modal} from "react-bootstrap";
import classes from "../../Global.module.css";

export default function NewTip(){
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    return(
        <Fragment>
            <Modal show={show} onHide={handleClose}
                   backdrop="static"
                   keyboard={false}
                   className={"w-100"}>
                <Modal.Header closeButton>
                    <Modal.Title>add new Tip</Modal.Title>
                </Modal.Header>
                <Modal.Body className={"w-100"}>
                    <Form className={""}>
                        <Form.Group className="mb-3 row" controlId="formBasicEmail">
                            <Form.Label className={"col-12 col-md-4"}>Title</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control className=""  type="text" placeholder="enter title of Tip" />
                            </div>

                        </Form.Group>
                        <Form.Group className="mb-3 row" controlId="formBasicEmail">
                            <Form.Label className={"col-12 col-md-4"}>description</Form.Label>
                            <div className={"col-12 col-md-8"}>
                                <Form.Control className={classes.h300} as={"textarea"}  type="text" placeholder="enter tip" />
                            </div>

                        </Form.Group>

                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={handleClose}>
                        Add
                    </Button>
                </Modal.Footer>
            </Modal>




            <button onClick={handleShow} className="btn btn-danger d-flex outline loginBtn" data-bss-hover-animate="rubberBand"
                    type="button">Add new Tip
            </button>
        </Fragment>

    )
}