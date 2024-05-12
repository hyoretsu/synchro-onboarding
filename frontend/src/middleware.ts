import type { NextRequest } from "next/server";

export default async function middleware(req: NextRequest) {
	// Se a rota do back estivesse funcionando, ia checar pelo 200 dela, se n ia redirecionar pro login
	// const res = await fetch(`${process.env.API_URL}/login`);
	// if (res.status !== 200) {
	// 	return NextResponse.redirect(new URL("/login", req.url));
	// }
}
