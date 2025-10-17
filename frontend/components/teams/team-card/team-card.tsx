import Image from "next/image";
import Link from "next/link";

type TeamCardProps = {
  backgroundImage: string;
  game: string;
};

const TeamCard = ({ backgroundImage, game }: TeamCardProps) => {
  return (
    <Link href={`/teams/${game}`} className="w-full h-full rounded-lg overflow-hidden">
      <div className="relative w-full h-84 flex-1 hover:scale-105 transition-transform duration-300 ease-in-out">
        <Image
          src={backgroundImage}
          className="absolute inset-0 w-full h-full object-cover grayscale"
          alt={`${game} Team`}
          fill
        />
        <div className="relative w-full h-full z-10">
          <Image
            src={`/games/${game}.svg`}
            className="absolute w-full h-full object-fill p-8 fill-red"
            alt={`${game} Logo`}
            fill
          />
        </div>
      </div>
    </Link>
  );
};
export default TeamCard;
