import TeamCard from "./team-card/team-card";

const Teams = () => {
  const teams = [
    { id: 1, name: "Valorant" },
    { id: 2, name: "League of Legends" },
    { id: 3, name: "Rainbow Six Siege" },
    { id: 4, name: "Rocket League" },
  ];

  return (
    <div className="py-8 max-w-7xl mx-auto px-2 space-y-10">
      <h2 className="font-bold text-3xl text-center mb-8">OUR TEAMS</h2>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4 place-items-center">
        {teams.map((team) => (
          <TeamCard
            key={team.name}
            backgroundImage={`/games/${team.name.toLowerCase().replaceAll(" ", "-")}-background.jpg`}
            game={team.name.toLowerCase().replaceAll(" ", "-")}
          />
        ))}
      </div>
    </div>
  );
};

export default Teams;
