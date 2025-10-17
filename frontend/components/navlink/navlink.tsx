"use client";

import { ReactNode } from "react";
import { usePathname } from "next/navigation";
import Link from "next/link";

function NavLink({ children, href, isVisible }: { children: ReactNode; href: string; isVisible: boolean }) {
  const pathname = usePathname();
  if (!isVisible) return null;
  return (
    <Link
      className={`truncate text-foreground hover:text-accent-foreground ${
        pathname === `/${href === "/" ? "" : href}` ? "font-semibold" : ""
      }`}
      href={href}>
      {children}
    </Link>
  );
}

export default NavLink;
