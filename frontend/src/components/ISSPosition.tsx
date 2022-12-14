import { getISSPosition } from 'api';
import { useEffect, useState } from 'react';
import { Marker, Popup } from 'react-leaflet';

export default function ISSPosition() {
  const [position, setPosition] = useState<[number, number] | null>(null);
  useEffect(() => {
    const interval = setInterval(() => {
      getISSPosition()
        .then(({ lat, lng }) => setPosition([lat, lng]))
        .catch(() => void 0);
    }, 30e3);
    return () => clearInterval(interval);
  });
  return position ? (
    <Marker position={position}>
      <Popup>Position de la Station Spatiale Internationale</Popup>
    </Marker>
  ) : null;
}
