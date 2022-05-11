import {Fragment, useEffect} from "react";
import Layout from "../Layout";
import './tip.css'
import {Accordion} from "react-bootstrap";

const DashContent = () => {
    return(<Fragment>
        <section className="py-5 bg-light">
            <div className="row">
                <div className="col-9">
                    <h1 className="text-center headerOfTip">Tips</h1>
                </div>
                <div className="col d-flex justify-content-lg-center align-items-lg-center">
                    <button className="btn btn-danger d-flex outline loginBtn" data-bss-hover-animate="rubberBand"
                            type="button">Add new Tip
                    </button>
                </div>
            </div>
            <div className="container">
                <div className="row">
                    <div className="col-md-6 offset-md-3">
                        <Accordion flush>
                            <Accordion.Item eventKey="0">
                                <Accordion.Header>Tip title 1</Accordion.Header>
                                <Accordion.Body>
                                    tip body, this will contains more details obout the tip
                                </Accordion.Body>
                            </Accordion.Item>
                            <Accordion.Item eventKey="1">
                                <Accordion.Header>Tip title 1</Accordion.Header>
                                <Accordion.Body>
                                    tip body, this will contains more details obout the tip
                                </Accordion.Body>
                            </Accordion.Item>
                        </Accordion>
                    </div>
                </div>
            </div>
        </section>
    </Fragment>)
}



const Tips =() =>{
    return <Layout>
        <DashContent/>
    </Layout>
}

export default Tips;