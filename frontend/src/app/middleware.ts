import { NextResponse } from "next/server";
import type { NextRequest } from "next/server";

// This function can be marked `async` if using `await` inside
export default async function middleware(req: NextRequest) {
	const authCookie = req.cookies.get("auth");

	if (req.nextUrl.pathname !== "/login" && !authCookie) {
		return NextResponse.redirect(new URL("/login", req.url));
	}
}
