import Link from "next/link";
import Image from "next/image";
import NavLink from "../navlink/navlink";

const Navbar = () => {
  const routes = [
    { name: "Home", path: "/", isProtected: false },
    { name: "About", path: "/about", isProtected: false },
    { name: "Teams", path: "/teams", isProtected: false },
    { name: "News", path: "/news", isProtected: false },
    { name: "Schedule", path: "/schedule", isProtected: false },
    { name: "Join", path: "/join", isProtected: false },
    { name: "Shop", path: "/shop", isProtected: false },
  ];

  return (
    <header className="fixed top-0 z-50 px-4 w-full bg-background/95 supports-[backdrop-filter]:bg-background/60 flex items-center backdrop-blur justify-between h-14 border-b border-border">
      <div className="flex justify-between items-center w-full max-w-7xl mx-auto">
        <Link href="/" className="text-lg font-semibold flex-1">
          <Image src="/esports-logo.png" alt="ETS Esports" width={70} height={20} />
        </Link>
        <nav className="hidden sm:flex space-x-4 lg:space-x-6 flex-1 justify-center items-center">
          {routes.map((route) => (
            <NavLink
              key={route.name}
              href={route.path}
              isVisible={!route.isProtected /* || (!!user && route.isProtected) */}>
              {route.name}
            </NavLink>
          ))}
        </nav>
        <div className="hidden sm:flex items-center space-x-4 flex-1 justify-end">
          {/* <ThemeToggle />
          {user ? <ProfileDropdown balance={user.balance} /> : <LoginDialog callToAction={t("sign-in")} />}
          <LocaleToggle /> */}
          {/* <LanguageDropdown /> */}
        </div>
        {/*         <MobileMenu isAuthenticated={!!user} /> */}
      </div>
    </header>
  );
};

export default Navbar;
