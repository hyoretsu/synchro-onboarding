import type { PropsWithChildren } from "react";
import "./_global.scss";

const siteColor = "#4F53B7";
const siteName = "Zaimu (Synchro Onboarding)";
const url = "https://synchro-onboarding.hyoretsu.com";

export const metadata = {
	applicationName: siteName,
	appleWebApp: {
		title: siteName,
	},
	metadataBase: new URL(url),
	openGraph: {
		images: [
			{
				url: "/opengraph.jpg",
				width: 1200,
				height: 627,
				alt: siteName,
			},
		],
		siteName,
		type: "website",
	},
	title: {
		default: siteName,
		template: `%s | ${siteName}`,
	},
	twitter: {
		card: "summary_large_image",
		creator: `${process.env.NEXT_PUBLIC_SITE_CONTENT_CREATOR}` || "@hyoretsu",
	},
};
export const viewport = {
	themeColor: siteColor,
};

export default function RootLayout({ children }: PropsWithChildren) {
	return (
		<html lang="en" suppressHydrationWarning>
			<head>
				<link rel="icon" type="image/svg+xml" href="favicon.svg" />
				<link rel="icon" type="image/png" href="favicon.png" />
				<link rel="manifest" href="/site.webmanifest" />
				<meta name="theme-color" content={siteColor} />
			</head>
			<body>
				{children}

				{process.env.NODE_ENV === "production" && <WebVitals />}
			</body>
		</html>
	);
}
