import {Fragment} from "react";
import Layout from "./Layout";

const DashContent = () => {
    return(<Fragment>
        <div>Dashboard</div>
    </Fragment>)
}



const Dashboard =() =>{
    return <Layout>
        <DashContent/>
    </Layout>
}

export default Dashboard;