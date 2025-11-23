import { AppSidebar } from "@/components/admin-sidebar/admin-sidebar";
import { SidebarProvider, SidebarTrigger } from "@/components/ui/sidebar";
import type { Metadata } from "next";
import { Instrument_Sans } from "next/font/google";

const instrumentSans = Instrument_Sans({
  variable: "--font-instrument-sans",
  subsets: ["latin"],
});

export const metadata: Metadata = {
  title: "ETS Esports Admin",
  description: "A platform for managing and organizing esports tournaments and events.",
};

export default function AdminLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <SidebarProvider>
      <AppSidebar />
      <main className="flex">
        <SidebarTrigger />
        {children}
      </main>
    </SidebarProvider>
  );
}
