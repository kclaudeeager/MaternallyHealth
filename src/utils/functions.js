export function convertFromStringToDate(responseDate) {
    const date = new Date(responseDate.replace(' ', 'T'));
    return(date)
}
export function validatePhoneNumber(input_str) {
    let re = /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;

    return re.test(input_str);
}
export function getFormFromObject(data) {
    const formData = new FormData();
    if (!data) {
        return null;
    }
    Object.keys(data).forEach(eachKey => {
        if (Array.isArray(data[eachKey])) {
            data[eachKey].forEach((each) => formData.append(eachKey, each));
        } else {
            formData.append(eachKey, data[eachKey]);
        }
    });
    return formData;
}
