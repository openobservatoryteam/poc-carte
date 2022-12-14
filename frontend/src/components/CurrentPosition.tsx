import { usePosition } from 'hooks';
import { Marker } from 'react-leaflet';

export default function CurrentPosition() {
  const position = usePosition();
  return position ? (
    <Marker
      alt="Position actuelle"
      position={position}
      title="Position actuelle"
    />
  ) : null;
}
