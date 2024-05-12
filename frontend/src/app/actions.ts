"use server";
import { RedirectType, redirect } from "next/navigation";

export async function createAccount(data: FormData) {
	const company = data.get("company");
	const type = data.get("type");

	if (!company || !type) {
		return;
	}

	const body = {
		company,
		type,
	};

	const res = await fetch(`${process.env.API_URL}/accounts`, {
		method: "POST",
		body: JSON.stringify(body),
		headers: {
			"Content-Type": "application/json",
		},
	});

	if (res.status !== 200) {
		return;
	}

	redirect("/");
}

export async function deleteAccount(accountId: string) {
	const res = await fetch(`${process.env.API_URL}/accounts?id=${accountId}`, {
		method: "DELETE",
	});

	if (res.status !== 200) {
		return;
	}
}

interface EditAccountDTO {
	id: string;
	company?: string;
	type?: string;
}

export async function editAccount(body: EditAccountDTO) {
	const res = await fetch(`${process.env.API_URL}/accounts`, {
		method: "PATCH",
		body: JSON.stringify(body),
		headers: {
			"Content-Type": "application/json",
		},
	});

	if (res.status !== 200) {
		return;
	}
}
