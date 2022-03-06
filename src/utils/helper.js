//
export const checkResponse = (json) => {
    if (json.error === true) {
      localStorage.removeItem('accountType');
      window.stop();
      window.location.replace('/login');
    //   throw new SessionExpiredError();
    }
    return json;
  }


export const postJson = async (url, data) => {
  const response = await fetch(`${server.address}${url}`, {
    method: 'POST',
    body: data ? JSON.stringify(data) : undefined,
    headers: {
      'Content-Type': 'application/json'
    },
    credentials: 'include'
  });
  return checkResponse(await response.json());
};


export const getJson = async (url) => {
  const response = await fetch(`${server.address}${url}`, {
    method: 'GET',
    credentials: 'include'
  });
  return checkResponse(await response.json());
};

export const putJson = async (url, data) => {
  const response = await fetch(`${server.address}${url}`, {
    method: 'PUT',
    body: data ? JSON.stringify(data) : undefined,
    headers: {
      'Content-Type': 'application/json'
    },
    credentials: 'include'
  });
  return checkResponse(await response.json());
};
