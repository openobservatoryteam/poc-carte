import { Logo } from 'assets';
import { CurrentPosition, NearbyObservations } from 'components';
import { Helmet } from 'react-helmet';
import { MapContainer, TileLayer } from 'react-leaflet';

export default function App() {
  return (
    <>
      <Helmet>
        <link
          rel="stylesheet"
          href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"
          integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
          crossOrigin=""
        />
      </Helmet>
      <header className="bg-neutral-200 dark:bg-neutral-800 flex h-[7vh] items-center justify-center py-1">
        <Logo className="h-full" />
      </header>
      <main>
        <MapContainer
          center={[49.443232, 1.099971]}
          className="h-[93vh] w-full"
          zoom={14}
        >
          <CurrentPosition />
          <NearbyObservations />
          <TileLayer
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
          />
        </MapContainer>
      </main>
    </>
  );
}
