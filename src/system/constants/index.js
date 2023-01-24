import endpoints from "./endpoints";
const status = {
    LOADING: 1,
    DONE: 2,
    ERROR: 3,
    NOTHING: 4
};
const Constants = {
    endpoints,
    BACKEND_URL:process.env.REACT_APP_DEFAULT_API,
    status,
}

export default Constants