import Image from "next/image";
import { Button } from "../ui/button";

const Hero = () => {
  return (
    <section className="flex items-center justify-center relative w-full h-screen overflow-hidden">
      <Image src="/hero-placeholder.webp" className="absolute w-full h-full object-cover" alt="Hero Image" fill />
      <div className="absolute z-10 w-full h-full opacity-20 bg-black" />
      <div className="relative z-20 flex flex-col items-center gap-4">
        <h1 className="text-4xl font-bold">Welcome to ETS Esports</h1>
        <Button>Join Us</Button>
      </div>
    </section>
  );
};

export default Hero;
