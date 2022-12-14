export const getISSPosition = (): Promise<{ lat: number; lng: number }> =>
  fetch('https://api.wheretheiss.at/v1/satellites/25544')
    .then((response) => response.json())
    .then((body) => ({ lat: body.latitude, lng: body.longitude }));
