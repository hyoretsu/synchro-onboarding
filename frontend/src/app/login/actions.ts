"use server";
import { redirect } from "next/navigation";

export async function closeModal() {
	redirect("/login");
}

export async function submitForm(data: FormData) {
	const body = {
		username: data.get("username"),
		password: data.get("password"),
	};

	const res = await fetch(`${process.env.API_URL}/login`, {
		body: JSON.stringify(body),
		method: "POST",
	});

	if (res.status !== 200) {
		redirect("/login?error=true");
	}

	redirect("/home");
}
