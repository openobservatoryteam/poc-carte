export const findAllNearby = (latitude: number, longitude: number) =>
  fetch(
    `https://pocback.kevinbioj.fr/observations/nearby?latitude=${latitude}&longitude=${longitude}`,
  ).then((response) => response.json());
