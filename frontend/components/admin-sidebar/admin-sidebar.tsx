import {
  Sidebar,
  SidebarContent,
  SidebarFooter,
  SidebarGroup,
  SidebarGroupContent,
  SidebarHeader,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
} from "@/components/ui/sidebar";
import {
  ChevronUp,
  Gamepad,
  Home,
  Newspaper,
  School,
  ShieldUser,
  Swords,
  User,
  User2,
  UserPlus,
  Users,
  UserX,
} from "lucide-react";
import Link from "next/link";
import { DropdownMenu, DropdownMenuContent, DropdownMenuItem, DropdownMenuTrigger } from "../ui/dropdown-menu";
import Image from "next/image";

export function AppSidebar() {
  const items = [
    {
      title: "Home",
      url: "/admin",
      icon: Home,
    },
    {
      title: "Teams",
      url: "/admin/teams",
      icon: Users,
    },
    {
      title: "Players",
      url: "/admin/players",
      icon: User,
    },
    {
      title: "Games",
      url: "/admin/games",
      icon: Gamepad,
    },
    {
      title: "Matches",
      url: "/admin/matches",
      icon: Swords,
    },
    {
      title: "Opponents",
      url: "/admin/opponents",
      icon: UserX,
    },
    {
      title: "Posts",
      url: "/admin/posts",
      icon: Newspaper,
    },
    {
      title: "Registrations",
      url: "/admin/registrations",
      icon: UserPlus,
    },
    {
      title: "Schools",
      url: "/admin/schools",
      icon: School,
    },
    {
      title: "Users",
      url: "/admin/users",
      icon: ShieldUser,
    },
  ];

  return (
    <Sidebar collapsible="icon">
      <SidebarHeader>
        <SidebarMenu>
          <SidebarMenuItem>
            <SidebarMenuButton asChild>
              <Link href="/admin" className="text-xl font-semibold flex">
                <Image src="/esports-logo.png" alt="ETS Esports" width={70} height={20} /> Admin
              </Link>
            </SidebarMenuButton>
          </SidebarMenuItem>
        </SidebarMenu>
      </SidebarHeader>
      <SidebarContent>
        <SidebarGroup>
          <SidebarGroupContent>
            <SidebarMenu>
              {items.map((item) => (
                <SidebarMenuItem key={item.title}>
                  <SidebarMenuButton asChild>
                    <Link href={item.url}>
                      <item.icon className="h-8 w-8" />
                      <span>{item.title}</span>
                    </Link>
                  </SidebarMenuButton>
                </SidebarMenuItem>
              ))}
            </SidebarMenu>
          </SidebarGroupContent>
        </SidebarGroup>
        <SidebarGroup />
      </SidebarContent>
      <SidebarFooter>
        <SidebarMenu>
          <SidebarMenuItem>
            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <SidebarMenuButton>
                  <User2 className="h-8 w-8" /> Username
                  <ChevronUp className="ml-auto" />
                </SidebarMenuButton>
              </DropdownMenuTrigger>
              <DropdownMenuContent className="w-[250px]">
                <DropdownMenuItem>
                  <span>Account</span>
                </DropdownMenuItem>
                <DropdownMenuItem>
                  <span>Sign out</span>
                </DropdownMenuItem>
              </DropdownMenuContent>
            </DropdownMenu>
          </SidebarMenuItem>
        </SidebarMenu>
      </SidebarFooter>
    </Sidebar>
  );
}
