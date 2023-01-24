export const formatJoiErorr = (error) => {
  if (!error) {
    return;
  }
  const message = error.replace(/"/g, '').replace(/Id/g, '');
  return message.charAt(0).toUpperCase() + message.slice(1);
};

export const convertToSlug = (param) => {
  const url = param
    .toLowerCase()
    .trim()
    .replace(/[^\w\s-]/g, '')
    .replace(/[\s_-]+/g, '-')
    .replace(/^-+|-+$/g, '');
  return url;
};

export const removeQuote = (text) => {
  if (!text) {
    return null;
  }
  return text.replace(/"/g, '');
};

