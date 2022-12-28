export const findAllNearby = (latitude: number, longitude: number) =>
  fetch(
    import.meta.env.VITE_API_URL + `/observations/nearby?latitude=${latitude}&longitude=${longitude}`,
  ).then((response) => response.json());
