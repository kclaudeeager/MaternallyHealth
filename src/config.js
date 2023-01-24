const settings = {
    backendURLLocal: "http://localhost:8080",
    backendURLRemote:"https://maternally-health-backend.herokuapp.com"
}
const status = {
    LOADING: 1,
    DONE: 2,
    ERROR: 3,
    NOTHING: 4
};
const dasBoardMenu = {
    USERS: 1,
    DASHBOARD: 2,
    ERROR: 3,
    NOTHING: 4
};
export default {
    backendURL:settings.backendURLRemote,
    status,
    dasBoardMenu
}