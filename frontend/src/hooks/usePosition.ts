import { useEffect, useState } from 'react';

export default function usePosition() {
  const [position, setPosition] = useState<[number, number] | null>(null);
  useEffect(() => {
    if ('geolocation' in navigator) {
      const geolocation = navigator.geolocation.watchPosition(
        ({ coords }) => setPosition([coords.latitude, coords.longitude]),
        () => void 0,
        { enableHighAccuracy: true, maximumAge: 15e3, timeout: 30e3 },
      );
      return () => navigator.geolocation.clearWatch(geolocation);
    }
  }, []);
  return position;
}
