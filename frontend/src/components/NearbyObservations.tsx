import { findAllNearby } from 'api';
import { useEffect, useState } from 'react';
import { Marker, Popup, useMap } from 'react-leaflet';

export default function NearbyObservations() {
  const map = useMap();
  const [observations, setObservations] = useState<typeof Marker[]>([]);
  useEffect(() => {
    const triggerUpdate = () => {
      const { lat, lng } = map.getCenter();
      findAllNearby(lat, lng).then((observations) =>
        setObservations(
          observations.payload.map((o: any) => (
            <Marker
              key={`OBS_${o.id}`}
              position={[o.location.latitude, o.location.longitude]}
            >
              <Popup>
                <p>
                  <h2>{o.celestialBody.name}</h2>
                  <b>Description :</b>{' '}
                  {o.description ?? <i>Aucune description</i>}
                  <br />
                  <b>Orientation :</b> {o.orientation}°
                  <br />
                  <b>Auteur :</b> {o.author.username}
                  <br />
                  <b>Date d&apos;envoi :</b> {o.createdAt}
                  <br />
                </p>
              </Popup>
            </Marker>
          )),
        ),
      );
    };
    triggerUpdate();
    map.addEventListener('moveend', triggerUpdate);
    return () => void map.removeEventListener('moveend', triggerUpdate);
  }, []);
  return <>{observations}</>;
}
