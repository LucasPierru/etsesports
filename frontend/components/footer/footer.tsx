import Image from "next/image";
import Link from "next/link";

const Footer = () => {
  return (
    <footer className="w-full border-t border-border mt-10">
      <div className="max-w-7xl mx-auto py-4 grid grid-cols-4 gap-y-4">
        <Link href="/">
          <Image src="/esports-logo.png" alt="ETS Esports" width={70} height={20} />
        </Link>
        <div>
          <h3 className="font-semibold mb-2">ETS Esports</h3>
          <div className="flex flex-col gap-1">
            <Link href="/about">About</Link>
            <Link href="/schedule">Schedule</Link>
            <Link href="/news">News</Link>
            <Link href="/teams">Teams</Link>
            <Link href="/join">Join</Link>
          </div>
        </div>
        <div>
          <h3 className="font-semibold mb-2">Socials</h3>
          <div className="flex flex-col gap-1">
            <Link href="https://discord.com/invite/YUhDtwUtpy" target="_blank" rel="noopener noreferrer">
              Discord
            </Link>
            <Link href="https://www.facebook.com/etsesports/" target="_blank" rel="noopener noreferrer">
              Facebook
            </Link>
            <Link href="https://www.instagram.com/esports_ets/" target="_blank" rel="noopener noreferrer">
              Instagram
            </Link>
            <Link href="https://www.linkedin.com/company/ets-esport/" target="_blank" rel="noopener noreferrer">
              LinkedIn
            </Link>
            <Link href="https://x.com/ETSesports" target="_blank" rel="noopener noreferrer">
              Twitter
            </Link>
            <Link href="https://www.youtube.com/@etsesports" target="_blank" rel="noopener noreferrer">
              Youtube
            </Link>
          </div>
        </div>
        <div>
          <h3 className="font-semibold mb-2">Legal</h3>
          <div className="flex flex-col gap-1">
            <Link href="/contact">Contact Us</Link>
            <Link href="/privacy-policy">Privacy Policy</Link>
            <Link href="/terms-of-service">Terms of Service</Link>
          </div>
        </div>
        <p className="text-center text-sm text-muted-foreground col-span-4">
          &copy; {new Date().getFullYear()} ETS Esports. All rights reserved.
        </p>
      </div>
    </footer>
  );
};

export default Footer;
